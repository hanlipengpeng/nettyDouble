package com.zzrenfeng.linux;
/**
 * sed 是一种在线编辑器，它一次处理一行内容
 * 
 * @author hanlipeng
 *
 */
public class Sed {
	
	
/**
 * sed用法
 * 
 * 删除：d命令
 * sed '2d' example-----删除example文件的第二行。
 * sed '2,$d' example-----删除example文件的第二行到末尾所有行。
 * sed '$d' example-----删除example文件的最后一行。
 * sed '/test/'d example-----删除example文件所有包含test的行。
 * sed -i '2d' example-----删除会被回写到文件，不加-i不会改变源文件
 * 
 * 替换：s命令
 * sed 's/test/mytest/g' example-----在整行范围内把test替换为mytest。如果没有g标记，则只有每行第一个匹配的test被替换成mytest。
 * sed -n 's/^test/mytest/p' example-----(-n)选项和p标志一起使用表示只打印那些发生替换的行。也就是说，如果某一行开头的test被替换成mytest，就打印它。
 * sed 's/^192.168.0.1/&localhost/' example-----&符号表示替换换字符串中被找到的部份。所有以192.168.0.1开头的行都会被替换成它自已加 localhost，变成192.168.0.1localhost。
 * sed -n 's/\(love\)able/\1rs/p' example-----love被标记为1，所有loveable会被替换成lovers，而且替换的行会被打印出来。
 * sed 's#10#100#g' example-----不论什么字符，紧跟着s命令的都被认为是新的分隔符，所以，“#”在这里是分隔符，代替了默认的“/”分隔符。表示把所有10替换成100。
 * 选定行的范围：逗号
 * 
 * 
 * 多点编辑：e命令
 * sed -e '1,5d' -e 's/test/check/' example-----(-e)选项允许在同一行里执行多条命令。如例子所示，第一条命令删除1至5行，第二条命令用check替换test。命令的执 行顺序对结果有影响。如果两个命令都是替换命令，那么第一个替换命令将影响第二个替换命令的结果。
 * 
 * 从文件读入：r命令
 * sed '/test/r file' example-----file里的内容被读进来，显示在与test匹配的行后面，如果匹配多行，则file的内容将显示在所有匹配行的下面。
 * 
 * 写入文件：w命令
 * sed -n '/test/w file' example-----在example中所有包含test的行都被写入file里。
 * 
 * 追加命令：a命令
 * sed '/^test/a\\--->this is a example' example    '----->this is a example'被追加到以test开头的行后面，sed要求命令a后面有一个反斜杠。
 * 
 * 插入：i命令
 * sed '/test/i\\
 * 
 * 
 * 后面的命令看help吧
 */

}
