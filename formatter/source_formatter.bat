REM #############################################################################################
REM #                                                                                           #
REM #   All of the current formatters suck. Calling an IDE Formatter from bat                   #
REM #     http://help.eclipse.org/kepler/topic/org.eclipse.jdt.doc.user/tasks/tasks-231.htm     #
REM #                                                                                           #
REM #   Will try this to remove IDE program requirement                                         #
REM #     http://liviutudor.com/2012/03/02/batch-source-formatting-in-eclipse-indigo/           #
REM #     http://www.franke.ms/#/eclipse-formatter-commandline.wiki                             #
REM #                                                                                           #
REM #   This is a free nor so recently updated formatter that may be an option...               #
REM #     https://github.com/notzippy/JALOPY2-MAIN                                              #
REM #                                                                                           #
REM #############################################################################################

set ECLIPSE_HOME=C:\ides\eclipse\juno\eclipse
%ECLIPSE_HOME%\eclipse.exe -vm java.exe -nosplash -application org.eclipse.jdt.core.JavaCodeFormatter -quiet -config source_formatter.properties ..\src\