package hack3

import java.nio.file._

class FileNameCreator(val dir: Path) {
	def create(name: String, ending: String, count: Int): Path = {
		val file = Paths.get(name + count + ending)
		if(Files.exists(dir.resolve(file))) { create(name, ending, count + 1) } else Files.createFile(dir.resolve(file))
	}
	
	def newPath(dir: Path): FileNameCreator = new FileNameCreator(dir)
}