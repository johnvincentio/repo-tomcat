package com.springinaction.knights;

import java.io.PrintStream;

public class Minstrel {
	private PrintStream stream;

	public Minstrel(PrintStream stream) {
		this.stream = stream;
	}

	public void singBeforeQuest() { // <co id="co_singBefore"/>
		stream.println("Fa la la; The knight is so brave!");
	}

	public void singAfterQuest() { // <co id="co_singAfter"/>
		stream.println("Tee hee he; The brave knight did embark on a quest!");
	}
}
