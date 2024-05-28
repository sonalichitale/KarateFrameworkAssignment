Feature: Do the post call using Excel file and Java

Background:
  * def serviceurl = 'https://petstore.swagger.io/v2/pet'


 Scenario Outline:Read data from Excel with Java and Do Post call
    Given url serviceurl
    * def javafileobj = Java.type('support.jsonfile')
    * def ID = javafileobj.read_And_Print_XL_AsPerTestData('<TestCaseName>', 'ID')
    And print 'Id is: ', ID
    * def Name = javafileobj.read_And_Print_XL_AsPerTestData('<TestCaseName>', 'Name')
    And print 'Name is: ', Name
    * def requestjsonbody = javafileobj.create_json_body(ID,Name)
    Then print 'Body is: ',requestjsonbody
    When request requestjsonbody
    And headers {Accept: 'application/json', Content-Type: 'application/json'}
    And method post
    And status 200


    Examples:
      |TestCaseName|
      |TC001|
      |TC002|
      |TC003|
      |TC004|
      |TC005|
      |TC006|
      |TC007|
      |TC008|
      |TC009|
      |TC010|
      |TC011|
      |TC012|
      |TC013|
      |TC014|
      |TC015|
      |TC016|
      |TC017|
      |TC018|
      |TC019|
      |TC020|
      |TC021|
      |TC022|
      |TC023|
      |TC024|
      |TC025|
      |TC026|
      |TC027|
      |TC028|
      |TC029|
      |TC030|



  Scenario Outline: Do Get call to validate Pet ID
    Given url 'https://petstore.swagger.io/v2/pet/<ID>'
    When method GET
    And headers {Accept: 'application/json', Content-Type: 'application/json'}
    And print response
    And response.id == '<ID>'
    And response.name == '<Name>'
    And status 200

    Examples:
      |ID|Name|
      |101|Lousy|
      |102|Orio |


  Scenario Outline: Do Delete call to validate Pet ID
    Given url 'https://petstore.swagger.io/v2/pet/<ID>'
    When method Delete
    And headers {Accept: 'application/json', Content-Type: 'application/json'}
    And print response
    And response.id == '<ID>'
    And response.code == 200
    And response.message == '<ID>'
    And response.name == '<Name>'



    Examples:
      |ID|Name|
      |101|Lousy|