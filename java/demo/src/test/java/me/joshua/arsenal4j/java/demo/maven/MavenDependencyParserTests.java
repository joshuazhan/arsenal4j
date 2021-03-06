package me.joshua.arsenal4j.java.demo.maven;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

import me.joshua.arsenal4j.java.demo.maven.MavenArtifact;
import me.joshua.arsenal4j.java.demo.maven.MavenDependencyParser;

public class MavenDependencyParserTests {

	private MavenDependencyParser parser;

	@Before
	public void init() {
		parser = new MavenDependencyParser();
	}

	@Test
	public void test() throws Throwable {
		List<MavenArtifact> deps = new LinkedList<>();
		File pomDir = new File(Resources.getResource("maven").toURI());
		for (File pom : FileUtils.listFiles(pomDir, TrueFileFilter.TRUE, null)) {
			deps.addAll(parser.parse(pom));
		}
		Assert.assertTrue(deps.size() > 0);
	}

}
