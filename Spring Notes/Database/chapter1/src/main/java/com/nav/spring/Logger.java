package com.nav.spring;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*
 * Dummy implementation of logger.
 */

@Component
public class Logger {

	private ConsoleWriter consoleWriter;
	private FileWriter fileWriter;

	@Resource
	public void setConsoleWriter(ConsoleWriter writer) {
		this.consoleWriter = writer;
	}
	@Resource
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
	public void writeFile(String text) {
		fileWriter.write(text);
	}
	
	
	public void writeConsole(String text) {
		if (consoleWriter == null)
			return;
		consoleWriter.write(text);
	}
	

}
