# jsoup.json: JSON parser for jsoup (Java HTML Parser)

**jsoup** is a Java library for working with real-world HTML. It provides a very convenient API for extracting and manipulating data, using the best of DOM, CSS, and jquery-like methods.

See [**jsoup.org**](https://jsoup.org/) for downloads and the full [API documentation](https://jsoup.org/apidocs/), [cookbook](https://jsoup.org/cookbook/).

**jsoup.json** is a powerful JSON [RFC 4627](http://www.ietf.org/rfc/rfc4627.txt), 7158, [RFC 7159](http://www.ietf.org/rfc/rfc7159.txt) parser for jsoup.
It can consume almost every text as JSON and convert it internally to an XML-tree.

No extra dependencies!

**example.json**
```json
{projects: [
{
  project_name = 'Google Gson',
  'url': "https://github.com/google/gson",
  "rating": 4.956,
  "contributors": [{
    first_name: Jesse, 'last_name': 'Wilson',
    "home_page": "https://medium.com/@swankjesse"
  }]
},{
  "project_name" => jsoup,
  "url": "https://jsoup.org",
  "rating": 5e10,
  "contributors": [
    {
      "first_name" = "Jonathan", "last_name" => "Hedley",
      "home_page": "https://jhy.io"
    },{
      "first_name": "Andrej", "last_name": "Fink"; "home_page": "https://github.com/magicprinc"
}]}]}
```
  
**java**
```java
Document doc = Jsoup.parse(exampleJson, "UTF-8", "", JsonTreeBuilder.jsonParser());
assert "Fink".equals(doc.select("#contributors obj:eq(1) #last_name").text());
assert "jsoup".equals(doc.select("#projects #project_name.str.unquoted").text());
//
assertEquals("<arr><val class=\"bool\">true</val><val class=\"bool\">true</val></arr>", JsonTreeBuilder.jsonToXml("[true, true]"));
``` 
        
**internal xml tree**
```xml
<obj>
 <arr id="projects">
  <obj>
   <val id="project_name" class="apos quoted str">
    Google Gson
   </val>
   <val id="url" class="quot quoted str">
    https://github.com/google/gson
   </val>
   <val id="rating" class="unquoted num">
    4.956
   </val>
   <arr id="contributors">
    <obj>
     <val id="first_name" class="unquoted str">
      Jesse
     </val>
     <val id="last_name" class="apos quoted str">
      Wilson
     </val>
     <val id="home_page" class="quot quoted str">
      https://medium.com/@swankjesse
     </val>
    </obj>
   </arr>
  </obj>
  <obj>
   <val id="project_name" class="unquoted str">
    jsoup
   </val>
   <val id="url" class="quot quoted str">
    https://jsoup.org
   </val>
   <val id="rating" class="unquoted num">
    5e10
   </val>
   <arr id="contributors">
    <obj>
     <val id="first_name" class="quot quoted str">
      Jonathan
     </val>
     <val id="last_name" class="quot quoted str">
      Hedley
     </val>
     <val id="home_page" class="quot quoted str">
      https://jhy.io
     </val>
    </obj>
    <obj>
     <val id="first_name" class="quot quoted str">
      Andrej
     </val>
     <val id="last_name" class="quot quoted str">
      Fink
     </val>
     <val id="home_page" class="quot quoted str">
      https://github.com/magicprinc
     </val>
    </obj>
   </arr>
  </obj>
 </arr>
</obj>
```