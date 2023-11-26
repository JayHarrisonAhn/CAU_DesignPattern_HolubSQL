# Car Rental Service
___
## Intro
개선한 Holub SQL을 이용한 자동차 렌탈 서비스입니다.
___
## Holub SQL Origin Function
- Minimum SQL Function
- Importer, Exporter
  - CSV Importer
  - CSV Exporter
  - JTable Exporter
___
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

___
## Environment
- JDK 1.8
- JUnit 5

