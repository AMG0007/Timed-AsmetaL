package org.asmeta.parser.util;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.asmeta.parser.ASMParser;
import org.eclipse.emf.common.util.EList;

import asmeta.definitions.ControlledFunction;
import asmeta.definitions.DerivedFunction;
import asmeta.definitions.Function;
import asmeta.definitions.MonitoredFunction;
import asmeta.structure.Asm;
import asmeta.structure.Body;

/**
 * print the information of a specification
 * 
 * @author garganti
 *
 */
public class AsmetaPrintInfo {

	class AsmInfo{

		Map<String,Integer> infoMap = new HashMap<>();
		void inc(String s) {
			int val;
			if (infoMap.containsKey(s)){
				val = infoMap.get(s)+1;
			} else{
				val = 1;
			}
			infoMap.put(s, val);
		}		
	}
	
	Asm asm;
	
	AsmetaPrintInfo(String asmPath) throws Exception{
		File asmFile = new File(asmPath);
		asm = ASMParser.setUpReadAsm(asmFile).getMain();		
	}
	
	AsmInfo getInfo() throws Exception{
		AsmInfo info = new AsmInfo();
		// functions
		EList<Function> funcs = asm.getHeaderSection().getSignature().getFunction();
		for(Function f: funcs){
			if (f instanceof ControlledFunction) {
				info.inc("controlled");
			} else if (f instanceof MonitoredFunction) {
				info.inc("monitored");
			} else if (f instanceof DerivedFunction) {
				info.inc("derived");
			} else{				
				throw new RuntimeException(f.getClass().getCanonicalName());
			}
		}
		// rules
		RuleCounter rc = new RuleCounter();
		info.infoMap.put("nrules",rc.getNumOfRules(asm));
		// rule declaration
		Body bodySection = asm.getBodySection();
		info.infoMap.put("nrulesdeclarations",bodySection.getRuleDeclaration().size());
		// properties
		info.infoMap.put("nproperties",bodySection.getProperty().size());
		return info;
	}
	
}
