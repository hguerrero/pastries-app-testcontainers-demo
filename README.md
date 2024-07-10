Add Microcks Extension

```bash
quarkus extension add io.github.microcks.quarkus:quarkus-microcks
```

Add `%dev` mock url in `applications.properties` file

```properties
%dev.quarkus.rest-client.pastries.url=${quarkus.microcks.default.http}/rest/API+Pastries/0.0.1
```

