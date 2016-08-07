package lance5057.tDefense.finishingAnvil.utilities;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class FileGetter extends SimpleFileVisitor<Path>
{
	final public List<String>	filenames	= new ArrayList<String>();

	@Override
	public FileVisitResult visitFile(Path file,
			BasicFileAttributes attr)
	{
		filenames.add(file.getFileName().toString());
		return FileVisitResult.CONTINUE;
	}
}
