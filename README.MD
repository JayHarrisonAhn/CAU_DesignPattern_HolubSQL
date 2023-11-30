# Car Rental Service
___
## Intro
개선한 Holub SQL을 이용한 자동차 렌탈 서비스입니다.  
  
사용자가 선택한 정보를 기반으로 DB에서 이용 가능한 리스트를 Holub SQL 기능을 활용하여 얻어냅니다.

이후, 사용자가 선택한 차량의 대여 정보가 DB에 Update됩니다.
___
## Application
<p><img src="assets/Application_demo.gif" width="480" height="480" alt="importer"></p>

___
## Application Use Case Diagrams
<p><img src="assets/UseCaseDiagram.png" width="546" height="516" alt="importer"></p>

## Application Use Case
<p><img src="assets/UseCase.png" width="457" height="318" alt="importer"></p>

___
## Holub SQL Origin Function
- Minimum SQL Function
- Importer, Exporter
  - CSV Importer
  - CSV Exporter
  - JTable Exporter
## Holub SQL Extended Function
- Importer, Exporter
  - HTML Exporter
  - XML Exporter
  - XML Importer
- Holub SQL Console Error Solved
- OrderBy, GroupBy, Distinct Keyword
___
## Architecture
### Importer
- Builder Pattern
<p><img src="./assets/Importer.png" width="361" height="178" alt="importer"></p>

### Exporter
- Builder Pattern
<p><img src="./assets/Exporter.png" width="330" height="187" alt="exporter"></p>

### Order By, Group By, Distinct Keyword
- Chain Of Responsibility Pattern
<p><img src="./assets/TableHandler.png" width="492" height="242" alt="handler"></p>

### Application
- MVC Pattern
<p><img src="./assets/MVC.png" width="586" height="471" alt="handler"></p>

- Factory Method Pattern
<p><img src="./assets/FactoryMethod.png" width="410" height="375" alt="handler"></p>

- Facade Pattern
<p><img src="./assets/Facade.png" width="426" height="437" alt="handler"></p>

___
## Environment
- JDK 21
- JUnit 5

