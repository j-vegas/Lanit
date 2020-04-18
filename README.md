# Lanit - Laboratory work
------
### Version 1.0

* Создал классы Main, Item, ItemContainer
* Создал extends Items: Brick
* Создал extends ItemContainer: Bag, Box, Stack

В классе Item реализовал методы `getInfo()`, `toString()`, `getNameItem()`, `getWeightItem()`, `getProperties()`.

### Version 1.1

* Добавил классы ItemAlreadyPlacedException, ItemStoreException

В классе ItemContainer реализованы методы `addItem()`, `removeItem()`

### Version 1.2

* Добавил класс Stack
* Подключил Allure к Maven-проекту
* Добавил тесты TestItem

### Version 1.3

* Произведена работа над улучшением кода
* Добавлены новые тесты в TestItem

### Version 1.4

* Произведен рефакторинг кода

Прогон тестов командой `mvn clean test`
| Cформировать html–отчет `mvn allure:serve`

![Image alt](https://github.com/J-Vegas/Lanit/blob/master/allurereport.png)
