package com.zzrenfeng.linux;
/**
 * awk是一个强大的文本分析工具，相对于grep的查找，sed的编辑，awk在其对数据分析并生成报告时，显得尤为强大。简单来说awk就是把文件逐行的读入，以空格为默认分隔符将每行切片，切开的部分再进行各种分析处理。
 * 
 * @author hanlipeng
 *
 */
public class Awk {

/**
 * awk
 * 
 * 如果只是显示最近登录的5个帐号
 * last -n 5 | awk  '{print $1}'
 * 
 * 如果只是显示/etc/passwd的账户
 * cat /etc/passwd |awk  -F ':'  '{print $1}'
 * 
 * 如果只是显示/etc/passwd的账户和账户对应的shell,而账户与shell之间以tab键分割
 * cat /etc/passwd |awk  -F ':'  '{print $1"\t"$7}'
 * 
 * 如果只是显示/etc/passwd的账户和账户对应的shell,而账户与shell之间以逗号分割,而且在所有行添加列名name,shell,在最后一行添加"blue,/bin/nosh"。
 * cat /etc/passwd |awk  -F ':'  'BEGIN {print "name,shell"}  {print $1","$7} END {print "blue,/bin/nosh"}'
 * 
 * 搜索/etc/passwd有root关键字的所有行
 * awk -F: '/root/' /etc/passwd
 * 
 * 搜索支持正则，例如找root开头的: awk -F: '/^root/' /etc/passwd
 * 
 * 搜索/etc/passwd有root关键字的所有行，并显示对应的shell
 * awk -F: '/root/{print $7}' /etc/passwd
 * 
 * awk内置变量
 * awk有许多内置变量用来设置环境信息，这些变量可以被改变，下面给出了最常用的一些变量。
 * 
 *  
 * ARGC               命令行参数个数
 * ARGV               命令行参数排列
 * ENVIRON            支持队列中系统环境变量的使用
 * FILENAME           awk浏览的文件名
 * FNR                浏览文件的记录数
 * FS                 设置输入域分隔符，等价于命令行 -F选项
 * NF                 浏览记录的域的个数
 * NR                 已读的记录数
 * OFS                输出域分隔符
 * ORS                输出记录分隔符
 * RS                 控制记录分隔符
 * 
 * 统计/etc/passwd:文件名，每行的行号，每行的列数，对应的完整行内容:
 * 
 * #awk  -F ':'  '{print "filename:" FILENAME ",linenumber:" NR ",columns:" NF ",linecontent:"$0}' /etc/passwd
 * filename:/etc/passwd,linenumber:1,columns:7,linecontent:root:x:0:0:root:/root:/bin/bash
 * filename:/etc/passwd,linenumber:2,columns:7,linecontent:daemon:x:1:1:daemon:/usr/sbin:/bin/sh
 * filename:/etc/passwd,linenumber:3,columns:7,linecontent:bin:x:2:2:bin:/bin:/bin/sh
 * filename:/etc/passwd,linenumber:4,columns:7,linecontent:sys:x:3:3:sys:/dev:/bin/sh
 * 
 * 
 * 使用printf替代print,可以让代码更加简洁，易读
 * awk  -F ':'  '{printf("filename:%s,linenumber:%s,columns:%s,linecontent:%s\n",FILENAME,NR,NF,$0)}' /etc/passwd
 * 
 * 
 * 
 * 高级awk编程
 * 除了awk的内置变量，awk还可以自定义变量
 * 
 * 下面统计/etc/passwd的账户人数
 * awk '{count++;print $0;} END{print "user count is ", count}' /etc/passwd
 * root:x:0:0:root:/root:/bin/bash
 * ......
 * user count is  40
 * 
 * 这里没有初始化count，虽然默认是0，但是妥当的做法还是初始化为0:
 * awk 'BEGIN {count=0;print "[start]user count is ", count} {count=count+1;print $0;} END{print "[end]user count is ", count}' /etc/passwd
 * [start]user count is  0
 * root:x:0:0:root:/root:/bin/bash
 * ...
 * [end]user count is  40
 * 
 * 
 * 统计某个文件夹下的文件占用的字节数
 * ls -l |awk 'BEGIN {size=0;} {size=size+$5;} END{print "[end]size is ", size}'
 * [end]size is  8657198
 *  
 * 
 * 如果以M为单位显示:
 * ls -l |awk 'BEGIN {size=0;} {size=size+$5;} END{print "[end]size is ", size/1024/1024,"M"}' 
 * [end]size is  8.25889 M
 * 注意，统计不包括文件夹的子目录。
 * 
 * 
 */

/**
 * 条件语句以后需要了再进行学习

 awk中的条件语句是从C语言中借鉴来的，见如下声明方式：

 
if (expression) {
    statement;
    statement;
    ... ...
}

if (expression) {
    statement;
} else {
    statement2;
}

if (expression) {
    statement1;
} else if (expression1) {
    statement2;
} else {
    statement3;
}
 
 

统计某个文件夹下的文件占用的字节数,过滤4096大小的文件(一般都是文件夹):

ls -l |awk 'BEGIN {size=0;print "[start]size is ", size} {if($5!=4096){size=size+$5;}} END{print "[end]size is ", size/1024/1024,"M"}' 
[end]size is  8.22339 M
 

循环语句

awk中的循环语句同样借鉴于C语言，支持while、do/while、for、break、continue，这些关键字的语义和C语言中的语义完全相同。

 

数组

  因为awk中数组的下标可以是数字和字母，数组的下标通常被称为关键字(key)。值和关键字都存储在内部的一张针对key/value应用hash的表格里。由于hash不是顺序存储，因此在显示数组内容时会发现，它们并不是按照你预料的顺序显示出来的。数组和变量一样，都是在使用时自动创建的，awk也同样会自动判断其存储的是数字还是字符串。一般而言，awk中的数组用来从记录中收集信息，可以用于计算总和、统计单词以及跟踪模板被匹配的次数等等。

 

显示/etc/passwd的账户

 
awk -F ':' 'BEGIN {count=0;} {name[count] = $1;count++;}; END{for (i = 0; i < NR; i++) print i, name[i]}' /etc/passwd
0 root
1 daemon
2 bin
3 sys
4 sync
5 games
......
 
这里使用for循环遍历数组
 */

}
