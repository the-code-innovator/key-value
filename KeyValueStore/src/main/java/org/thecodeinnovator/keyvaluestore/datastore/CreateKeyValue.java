package org.thecodeinnovator.keyvaluestore.datastore;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.thecodeinnovator.keyvaluestore.exceptions.ExistingKeyException;

public class CreateKeyValue {
	public CreateKeyValue(String filePath, String key, String value) throws IOException, ExistingKeyException {
		StringBuffer buffer = new StringBuffer(new String(value));
		if ((new File(filePath).exists()) && !(this.checkCollision(filePath, key))) {
			new FileWriter(new File(filePath)).append(buffer.toString());
		}
	}
	boolean checkCollision(String filePath, String key) throws ExistingKeyException {
		for (String i : new File(filePath).list()) {
			if (new String(i.split(":", 1)[0]).equals(key)) {
				return true;
			}
		}
		return false;
	}
}