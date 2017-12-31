#!/bin/bash
name='l am sailong'
echo $name
for skill in Java c c++ node; do
	echo "l like ${skill}"
done
your_name="qinjx"
greeting="hello, "$your_name" !"
greeting_1="hello, ${your_name} !"
echo $greeting $greeting_1
echo ${#name}
