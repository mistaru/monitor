# monitor
Solving the "readers-writers" problem using a monitor

Читатели могут искать нужную им литературу, а работники
библиотеки могут этот каталог обновлять. Работники при внесении изменений не должны
мешать друг другу, а также не должны допускать читателей к данным в момент их
изменения, чтобы предотвратить получение читателями недостоверной информации.
Читатели могут пользоваться каталогами по несколько человек одновременно. Если
рассматривать общее решение, то читатели были бы вынуждены входить в каталог по
одному, что вызвало бы неоправданные задержки и очереди.