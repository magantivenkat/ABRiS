/*
 * Copyright 2018 Barclays Africa Group Limited
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package za.co.absa.abris.avro.parsing.utils

import org.apache.avro.Schema
import za.co.absa.abris.avro.schemas.SchemaLoader

/**
 * This class provides utility methods to cope with Avro schemas.
 */
object AvroSchemaUtils {
  
  /**
   * Parses a plain Avro schema into an org.apache.avro.Schema implementation.
   */
  def parse(schema: String): Schema = new Schema.Parser().parse(schema)  
  
  /**
   * Loads an Avro org.apache.avro.Schema from the path.
   */
  def load(path: String): Schema = {    
    parse(loadPlain(path))
  }    
  
  /**
   * Loads an Avro's plain schema from the path.
   */
  def loadPlain(path: String) = {
    SchemaLoader.loadFromFile(path)
  }

  def loadConfluent(params: Map[String,String]): Schema = {
    SchemaLoader.loadFromSchemaRegistry(params)
  }
}