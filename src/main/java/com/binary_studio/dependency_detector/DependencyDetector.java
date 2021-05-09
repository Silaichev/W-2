package com.binary_studio.dependency_detector;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public final class DependencyDetector {

	private DependencyDetector() {
	}

	public static boolean canBuild(DependencyList deplib) {
		/*// TODO: Implement*/
		List<String> list;
		if(deplib.dependencies.size()==0){
			return true;
		}

		for(int i =0;i<deplib.libraries.size()-1;i++){

			list = new LinkedList<>();
			list.add(deplib.libraries.get(i));
			while(!yesNo(list)&&deplib.existDependency(list.get(list.size()-1))){
				list.add(deplib.findDependency(list.get(list.size()-1)));
			}
			if(yesNo(list)){
				return false;
			}

			if(i==deplib.libraries.size()-1&&!yesNo(list)){
				return true;
			}
		}

		return false;
	}
	private static boolean yesNo(List<String> listWithDuplicates){
		List<String> listWithoutDuplicates = listWithDuplicates.stream()
				.distinct()
				.collect(Collectors.toList());
		if(listWithDuplicates.size()!=listWithoutDuplicates.size()){
			return true;
		}else{
			return false;
		}
	}

}
