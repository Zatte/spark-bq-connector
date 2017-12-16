package com.github.zatte.sparkbqconnector

import 

class LegacyRelation(location: String, userSchema: StructType)
(@transient val sqlContext: SQLContext) extends BaseRelation with Serializable {
  override def schema: StructType = {
    if (this.userSchema != null) {
      return this.userSchema
    }
    else {
      return StructType(Seq(StructField("name", StringType, true), 
                            StructField("age", IntegerType, true)))
    }
  }
}
