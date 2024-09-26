Test and check error

```bash
http :8080/api/orders 'customerId=X1234' 'price=10' 'productQuantity[productName]=Millefeuille' 'productQuantity[quantity]=1'
```

Add Microcks Extension

```bash
quarkus extension add io.github.microcks.quarkus:quarkus-microcks
```

Add `%dev` mock url in `applications.properties` file

```properties
%dev.quarkus.rest-client.pastries.url=${quarkus.microcks.default.http}/rest/API+Pastries/0.0.1
```

Test a success

```bash
http :8080/api/orders 'customerId=X1234' 'price=10' 'productQuantity[productName]=Millefeuille' 'productQuantity[quantity]=1'
```

Test an error

```bash
http :8080/api/orders 'customerId=X1234' 'price=10' 'productQuantity[productName]=Eclair Chocolat' 'productQuantity[quantity]=1'
```

