#!/usr/bin/bash
#

for file in $(find ./* -type f -name "*.*" );
do
	# echo $(basename $file);
	echo $file;
	echo $(file -i $file | cut -d ';' -f2 | sed "s/ charset=//");
done


# file -i ./3.java_oop/lesson.5.generics/genericsInheritance/.idea/misc.xml | cut -d ';' -f2 | sed "s/ charset=//"




