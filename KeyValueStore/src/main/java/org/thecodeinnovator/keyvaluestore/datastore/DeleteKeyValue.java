package org.thecodeinnovator.keyvaluestore.datastore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class DeleteKeyValue {
	public DeleteKeyValue(String filePath, String key) throws IOException {
		if (this.keyExists(filePath, key)) {
			this.removeKeyValuePair(filePath, key);
		}
	}
	boolean keyExists(String filePath, String key) {
		for (String i : new File(filePath).list()) {
			if (i.split(":", 1)[0].equals(new String(key))) {
				return true;
			}
		}
		return false;
	}
	void removeKeyValuePair(String filePath, String key) throws IOException {
		String[] currentFile = new File(filePath).list();
		Files.write(new File(filePath).toPath(), new byte[0], StandardOpenOption.TRUNCATE_EXISTING);
		for (String i : currentFile) {
			if (!(i.split(":", 1)[0].equals(key))) {
				new FileWriter(new File(filePath)).write(i);
			}
		}
	}
}