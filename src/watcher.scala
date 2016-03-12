package hack3

import java.nio.file._
import scala.annotation._

case class DirectoryWatcher(dir: Path) {
	val numFiles = dir.toFile.listFiles.size
	
	def dirChanged: (DirectoryWatcher, Boolean) = {
		val newNumFiles = dir.toFile.listFiles.size
		if(numFiles == newNumFiles) (this, false) else (DirectoryWatcher(dir), true)
	}
}

object DirectoryWatcher {
	@tailrec
	def watch(watcher: DirectoryWatcher) {
		val (watcherNew, result) = watcher.dirChanged
		println("file chaged: ", result)
		Thread.sleep(1000)
		watch(watcherNew)
	}
}