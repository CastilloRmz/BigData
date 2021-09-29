# Pr-ctica-Evaluatoria---Unidad-1
Practica para evaluar la unidad 1
1.
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.SparkSession

2. 
val session = SparkSession.builder().getOrCreate
session: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@1be3e952

3.
val df_netflix = session.read.option("header", "true").option("inferSchema", true).csv("Netflix_2011_2016.csv")
df_netflix: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 5 more fields]

4.
df_netflix.columns
res0: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)

5.
df_netflix.printSchema()
root
 |-- Date: timestamp (nullable = true)
 |-- Open: double (nullable = true)
 |-- High: double (nullable = true)
 |-- Low: double (nullable = true)
 |-- Close: double (nullable = true)
 |-- Volume: integer (nullable = true)
 |-- Adj Close: double (nullable = true)

6.
df_netflix.head(5)
res2: Array[org.apache.spark.sql.Row] = Array([2011-10-24 00:00:00.0,119.100002,120.28000300000001,115.100004,118.839996,120460200,16.977142], [2011-10-25 00:00:00.0,74.899999,79.390001,74.249997,77.370002,315541800,11.052857000000001], [2011-10-26 00:00:00.0,78.73,81.420001,75.399997,79.400002,148733900,11.342857], [2011-10-27 00:00:00.0,82.179998,82.71999699999999,79.249998,80.86000200000001,71190000,11.551428999999999], [2011-10-28 00:00:00.0,80.280002,84.660002,79.599999,84.14000300000001,57769600,12.02])

7.
val df_netflix2 = df_netflix.withColumn("HV Ratio", df_netflix("High")/df_netflix("Volume"))
df_netflix2: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 6 more fields]

8.
df_netflix.select(mean("Open")).show()
+------------------+
|         avg(Open)|
+------------------+
|230.39351086656092|
+------------------+

9.
df_netflix.select(mean("Close")).show()
+----------------+
|      avg(Close)|
+----------------+
|230.522453845909|
+----------------+


df_netflix.select(max("Volume")).show()
+-----------+
|max(Volume)|
+-----------+
|  315541800|
+-----------+

10.
df_netflix.select(min("Volume")).show()
+-----------+
|min(Volume)|
+-----------+
|    3531300|
+-----------+

a.
val Day = df_netflix.where($"Close" < 600).count()
Day: Long = 1218

b.
val Day = df_netflix.where($"High" > 500).count().toFloat
Day: Float = 62.0

c.
df_netflix.select(corr("High", "Volume")).show()
+--------------------+
|  corr(High, Volume)|
+--------------------+
|-0.20960233287942157|
+--------------------+

d.
df_netflix.groupBy(year($"Date")).max("High").show()
+----------+------------------+                                                 
|year(Date)|         max(High)|
+----------+------------------+
|      2015|        716.159996|
|      2013|        389.159988|
|      2014|        489.290024|
|      2012|        133.429996|
|      2016|129.28999299999998|
|      2011|120.28000300000001|
+----------+------------------+

e.
val df_netflix3 = df_netflix.groupBy(year($"Date"), month($"Date")).mean("Close"). toDF("Year","Month","Mean")
df_netflix3: org.apache.spark.sql.DataFrame = [Year: int, Month: int ... 1 more field]

df_netflix3.orderBy($"Year",$"Month").show()
+----+-----+------------------+                                                 
|Year|Month|              Mean|
+----+-----+------------------+
|2011|   10| 87.11500133333334|
|2011|   11| 79.76380923809522|
|2011|   12| 70.30428566666667|
|2012|    1| 97.75149895000001|
|2012|    2|119.92049895000002|
|2012|    3|113.00181809090908|
|2012|    4|100.88399985000001|
|2012|    5| 72.98772681818181|
|2012|    6| 65.75380899999999|
|2012|    7|  75.2542851904762|
|2012|    8|60.736521347826084|
|2012|    9| 56.57736921052631|
|2012|   10| 65.78095142857143|
|2012|   11| 80.04190514285713|
|2012|   12| 89.40500014999998|
|2013|    1|117.01380985714289|
|2013|    2|182.45684194736842|
|2013|    3|       184.6934989|
|2013|    4|182.83045363636364|
|2013|    5|223.71999777272728|
+----+-----+------------------+
only showing top 20 rows

