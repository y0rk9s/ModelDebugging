/*
* generated by Xtext
*/
package org.gemoc.mocc.cometafsm.model.xtext.parser.antlr;

import java.io.InputStream;
import org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider;

public class FSMDslAntlrTokenFileProvider implements IAntlrTokenFileProvider {
	
	public InputStream getAntlrTokenFile() {
		ClassLoader classLoader = getClass().getClassLoader();
    	return classLoader.getResourceAsStream("org/gemoc/mocc/cometafsm/model/xtext/parser/antlr/internal/InternalFSMDsl.tokens");
	}
}
