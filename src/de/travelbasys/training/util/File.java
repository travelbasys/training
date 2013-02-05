package de.travelbasys.training.util;

import java.net.URI;

public class File extends java.io.File {

	public File(String pathname) {
		super(pathname);
	}

	public File(java.io.File parent, String child) {
		super(parent, child);
	}

	public File(String parent, String child) {
		super(parent, child);
	}

	public File(URI uri) {
		super(uri);
	}

	private static final long serialVersionUID = 1L;

	public static String getExtension(java.io.File f) {
		String ext = null;
		String s = f.getName();
		int i = s.lastIndexOf('.');

		if (i > 0 && i < s.length() - 1)
			ext = s.substring(i + 1).toLowerCase();

		if (ext == null) {
			ext = "";
		}
		return ext;
	}
}
