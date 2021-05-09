package com.binary_studio.dependency_detector;

import java.util.List;
import java.util.stream.Collectors;

public class DependencyList {

	public final List<String> libraries;

	public final List<String[]> dependencies;

	public DependencyList(List<String> libraries, List<String[]> dependencies) {
		this.libraries = libraries;
		this.dependencies = dependencies;
	}
	public String findDependency(String lib){
		List<String[]> list = dependencies.stream().filter(d->d[0].equals(lib)).collect(Collectors.toList());
		if(list.size()>0){
			return list.get(0)[1];
		}
		return null;
	}
	public boolean existDependency(String lib){
		List<String[]> list = dependencies.stream().filter(d->d[0].equals(lib)).collect(Collectors.toList());
		if(list.size()>0){
			return true;
		}else{
			return false;
		}
	}

}
