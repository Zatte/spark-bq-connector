package com.github.zatte.sparkbqconnector

class DefaultSource extends RelationProvider with SchemaRelationProvider {
  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String])
    : BaseRelation = {
    createRelation(sqlContext, parameters, null)
  }
  override def createRelation(sqlContext: SQLContext, parameters: Map[String, String]
    , schema: StructType)
    : BaseRelation = {
    parameters.getOrElse("path", sys.error("'path' must be specified for our data."))
    return new LegacyRelation(parameters.get("path").get, schema)(sqlContext)
  }
}
