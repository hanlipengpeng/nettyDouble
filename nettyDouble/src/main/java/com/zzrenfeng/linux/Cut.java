package com.zzrenfeng.linux;
/**
 * cut用法
 * 命令可以从一个文本文件或者文本流中提取文本列。
 * 
 * sort wc uniq
 * @author rf
 *
 */
public class Cut {
/**
 * cut的用法：cut是对列进行截取的 相当于awk的用法
 * 
 * 将 PATH 变量取出，我要找出第五个路径。
 * echo $PATH | cut -d ':' -f 5
 * 
 * 将 PATH 变量取出，我要找出第三和第五个路径。
 * echo $PATH | cut -d ':' -f 3,5
 * 
 * 将 PATH 变量取出，我要找出第三到最后一个路径。
 * echo $PATH | cut -d ':' -f 3-
 * 
 * 将 PATH 变量取出，我要找出第一到第三个路径。
 * echo $PATH | cut -d ':' -f 1-3
 */
	
/**
 * wc的命令
 * 
 * wc主要是进行统计的
 * wc -l /etc/passwd   #统计行数，在对记录数时，很常用
 * wc -w /etc/passwd  #统计单词出现次
 * wc -m /etc/passwd  #统计文件的字符数
 */
	
/**
 * sort [-fbMnrtuk] [file or stdin]
 * 
 * 选项与参数：
 * -f  ：忽略大小写的差异，例如 A 与 a 视为编码相同；
 * -b  ：忽略最前面的空格符部分；
 * -M  ：以月份的名字来排序，例如 JAN, DEC 等等的排序方法；
 * -n  ：使用『纯数字』进行排序(默认是以文字型态来排序的)；
 * -r  ：反向排序；
 * -u  ：就是 uniq ，相同的数据中，仅出现一行代表；
 * -t  ：分隔符，默认是用 [tab] 键来分隔；
 * -k  ：以那个区间 (field) 来进行排序的意思
 * 
 * sort 是默认以第一个数据来排序，而且默认是以字符串形式来排序,所以由字母 a 开始升序排序。
 * 
 * 内容是以 : 来分隔的，我想以第三栏来排序，该如何
 * cat /etc/passwd | sort -t ':' -k 3
 * 
 * 默认是以字符串来排序的，如果想要使用数字排序：
 * cat /etc/passwd | sort -t ':' -k 3n
 * 
 * 默认是升序排序，如果要倒序排序，如下
 * cat /etc/passwd | sort -t ':' -k 3nr
 * 
 * 如果要对/etc/passwd,先以第六个域的第2个字符到第4个字符进行正向排序，再基于第一个域进行反向排序。
 * cat /etc/passwd |  sort -t':' -k 6.2,6.4 -k 1r 
 * 
 * 查看/etc/passwd有多少个shell:对/etc/passwd的第七个域进行排序，然后去重:
 * cat /etc/passwd |  sort -t':' -k 7 -u
 */
	
/**
 * uniq [-icu]
 * 
 * 选项与参数：
 * -i   ：忽略大小写字符的不同；
 * -c  ：进行计数
 * -u  ：只显示唯一的行
 * 
 * 注意：去重需要先排序，也就是只有两行是一块的才能去重
 */
}
