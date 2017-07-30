# luminus-chunked-response

## Prerequisites

You will need [Leiningen][1] 2.0 or above installed.

[1]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:
```
lein run
```    

```
curl  -ivs --raw http://localhost:3000/tail\?file\=test.html
```

```
echo "<p>test</p>" >> ./test.html
```
