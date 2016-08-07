package mekanism.api.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ListUtils
{
	public static <V> List<V> inverse(List<V> list)
	{
		final List<V> toReturn = new ArrayList<V>();

		for(int i = list.size() - 1; i >= 0; i--)
		{
			toReturn.add(list.get(i));
		}

		return toReturn;
	}

	public static <V> List<V> cap(List<V> list, int cap)
	{
		List<V> toReturn = new ArrayList<V>();

		if(list.size() <= cap)
		{
			toReturn = copy(list);
		}
		else
		{
			int count = 0;

			for(final V obj : list)
			{
				count++;

				toReturn.add(obj);

				if(count == cap)
				{
					break;
				}
			}
		}

		return toReturn;
	}

	public static <V> List<V> copy(List<V> list)
	{
		final List<V> toReturn = new ArrayList<V>();

		for(final V obj : list)
		{
			toReturn.add(obj);
		}

		return toReturn;
	}

	public static <V> List<V> merge(List<V> listOne, List<V> listTwo)
	{
		final List<V> newList = new ArrayList<V>();

		for(final V obj : listOne)
		{
			newList.add(obj);
		}

		for(final V obj : listTwo)
		{
			newList.add(obj);
		}

		return newList;
	}

	public static <V> List<V> capRemains(List<V> list, int cap)
	{
		final List<V> toReturn = new ArrayList<V>();

		if(list.size() <= cap)
		{
			return toReturn;
		}
		else
		{
			inverse(list);

			final int iterNeeded = list.size() - cap;
			int count = 0;

			for(final V obj : list)
			{
				count++;

				toReturn.add(obj);

				if(count == iterNeeded)
				{
					break;
				}
			}

			return toReturn;
		}
	}

	public static <V> ArrayList<List<V>> split(List<V> list, int divide)
	{
		int remain = list.size() % divide;
		final int size = (list.size() - remain) / divide;

		final ArrayList<List<V>> toReturn = new ArrayList<List<V>>();

		for(int i = 0; i < divide; i++)
		{
			toReturn.add(i, new ArrayList<V>());
		}

		for(final List<V> iterSet : toReturn)
		{
			final List<V> removed = new ArrayList<V>();

			int toAdd = size;

			if(remain > 0)
			{
				remain--;
				toAdd++;
			}

			for(final V obj : list)
			{
				if(toAdd == 0)
				{
					break;
				}

				iterSet.add(obj);
				removed.add(obj);
				toAdd--;
			}

			for(final V obj : removed)
			{
				list.remove(obj);
			}
		}

		return toReturn;
	}

	public static <V> V getTop(List<V> list)
	{
		for(final V obj : list)
		{
			return obj;
		}

		return null;
	}

	public static <V> List<V> asList(Set<V> set)
	{
		return (List<V>) Arrays.asList(set.toArray());
	}

	public static <V> List<V> asList(V... values)
	{
		return Arrays.asList(values);
	}

	public static double[] splitDouble(int size, double num)
	{
		final double[] split = new double[size];

		for(int i = 0; i < size; i++)
		{
			final double remain = num % size;
			double ret = (num - remain) / size;
			ret += remain;

			split[i] = ret;
			num -= remain;
		}

		return split;
	}

	public static double[] percent(double[] values)
	{
		final double[] ret = new double[values.length];
		double total = 0;

		for(final double d : values)
		{
			total += d;
		}

		for(int i = 0; i < values.length; i++)
		{
			ret[i] = values[i] / total;
		}

		return ret;
	}

	public static int[] calcPercentInt(double[] percent, int val)
	{
		final int[] ret = new int[percent.length];

		for(int i = 0; i < percent.length; i++)
		{
			ret[i] = (int) Math.round(val * percent[i]);
		}

		int newTotal = 0;
		for(final int i : ret)
		{
			newTotal += i;
		}

		int diff = val - newTotal;

		if(diff != val)
		{
			for(int i = 0; i < ret.length; i++)
			{
				final int num = ret[i];

				if(diff < 0 && num == 0)
				{
					continue;
				}

				if(diff > 0)
				{
					ret[i]++;
					diff--;
				}
				else if(diff < 0)
				{
					ret[i]--;
					diff++;
				}

				if(diff == 0)
				{
					return ret;
				}
			}
		}

		return ret;
	}

	public static int[] splitInt(int size, int num)
	{
		final int[] split = new int[size];

		for(int i = 0; i < size; i++)
		{
			final int remain = num % size;
			int ret = (num - remain) / size;
			ret += remain;

			split[i] = ret;
			num -= remain;
		}

		return split;
	}

	public static double[] percent(int[] values)
	{
		final double[] ret = new double[values.length];
		double total = 0;

		for(final double d : values)
		{
			total += d;
		}

		for(int i = 0; i < values.length; i++)
		{
			ret[i] = values[i] / total;
		}

		return ret;
	}
}
