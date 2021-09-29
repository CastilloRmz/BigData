# Pr-ctica-Evaluatoria---Unidad-1<br>
Practica para evaluar la unidad 1<br>
1.<br>
import org.apache.spark.sql.SparkSession<br>
import org.apache.spark.sql.SparkSession<br>

2. <br>
val session = SparkSession.builder().getOrCreate
session: org.apache.spark.sql.SparkSession = org.apache.spark.sql.SparkSession@1be3e952<br>

3.<br>
val df_netflix = session.read.option("header", "true").option("inferSchema", true).csv("Netflix_2011_2016.csv")
df_netflix: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 5 more fields]<br>

4.<br>
df_netflix.columns
res0: Array[String] = Array(Date, Open, High, Low, Close, Volume, Adj Close)<br>

5.<br>
df_netflix.printSchema()
root
 |-- Date: timestamp (nullable = true)<br>
 |-- Open: double (nullable = true)<br>
 |-- High: double (nullable = true)<br>
 |-- Low: double (nullable = true)<br>
 |-- Close: double (nullable = true)<br>
 |-- Volume: integer (nullable = true)<br>
 |-- Adj Close: double (nullable = true)<br>

6.<br>
df_netflix.head(5)
res2: Array[org.apache.spark.sql.Row] = Array([2011-10-24 00:00:00.0,119.100002,120.28000300000001,115.100004,118.839996,120460200,16.977142], [2011-10-25 00:00:00.0,74.899999,79.390001,74.249997,77.370002,315541800,11.052857000000001], [2011-10-26 00:00:00.0,78.73,81.420001,75.399997,79.400002,148733900,11.342857], [2011-10-27 00:00:00.0,82.179998,82.71999699999999,79.249998,80.86000200000001,71190000,11.551428999999999], [2011-10-28 00:00:00.0,80.280002,84.660002,79.599999,84.14000300000001,57769600,12.02])<br>

7.<br>
val df_netflix2 = df_netflix.withColumn("HV Ratio", df_netflix("High")/df_netflix("Volume"))
df_netflix2: org.apache.spark.sql.DataFrame = [Date: timestamp, Open: double ... 6 more fields]<br>

8.<br>
df_netflix.select(mean("Open")).show()<br>
+------------------+<br>
|         avg(Open)|<br>
+------------------+<br>
|230.39351086656092|<br>
+------------------+<br>

9.<br>
df_netflix.select(mean("Close")).show()<br>
+----------------+<br>
|      avg(Close)|<br>
+----------------+<br>
|230.522453845909|<br>
+----------------+<br>


df_netflix.select(max("Volume")).show()<br>
+-----------+<br>
|max(Volume)|<br>
+-----------+<br>
|  315541800|<br>
+-----------+<br>

10.<br>
df_netflix.select(min("Volume")).show()<br>
+-----------+<br>
|min(Volume)|<br>
+-----------+<br>
|    3531300|<br>
+-----------+<br>

a.<br>
val Day = df_netflix.where($"Close" < 600).count()<br>
Day: Long = 1218

b.<br>
val Day = df_netflix.where($"High" > 500).count().toFloat<br>
Day: Float = 62.0

c.<br>
df_netflix.select(corr("High", "Volume")).show()<br>
+--------------------+<br>
|  corr(High, Volume)|<br>
+--------------------+<br>
|-0.20960233287942157|<br>
+--------------------+<br>

d.<br>
df_netflix.groupBy(year($"Date")).max("High").show()<br>
+----------+------------------+    <br>                                             
|year(Date)|         max(High)|<br>
+----------+------------------+<br>
|      2015|        716.159996|<br>
|      2013|        389.159988|<br>
|      2014|        489.290024|<br>
|      2012|        133.429996|<br>
|      2016|129.28999299999998|<br>
|      2011|120.28000300000001|<br>
+----------+------------------+<br>

e.<br>
val df_netflix3 = df_netflix.groupBy(year($"Date"), month($"Date")).mean("Close"). toDF("Year","Month","Mean")
df_netflix3: org.apache.spark.sql.DataFrame = [Year: int, Month: int ... 1 more field]

df_netflix3.orderBy($"Year",$"Month").show()<br>
+----+-----+------------------+     <br>                                            
|Year|Month|              Mean|<br>
+----+-----+------------------+<br>
|2011|   10| 87.11500133333334|<br>
|2011|   11| 79.76380923809522|<br>
|2011|   12| 70.30428566666667|<br>
|2012|    1| 97.75149895000001|<br>
|2012|    2|119.92049895000002|<br>
|2012|    3|113.00181809090908|<br>
|2012|    4|100.88399985000001|<br>
|2012|    5| 72.98772681818181|<br>
|2012|    6| 65.75380899999999|<br>
|2012|    7|  75.2542851904762|<br>
|2012|    8|60.736521347826084|<br>
|2012|    9| 56.57736921052631|<br>
|2012|   10| 65.78095142857143|<br>
|2012|   11| 80.04190514285713|<br>
|2012|   12| 89.40500014999998|<br>
|2013|    1|117.01380985714289|<br>
|2013|    2|182.45684194736842|<br>
|2013|    3|       184.6934989|<br>
|2013|    4|182.83045363636364|<br>
|2013|    5|223.71999777272728|<br>
+----+-----+------------------+<br>
only showing top 20 rows<br>

