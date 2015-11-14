require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.sql.ResultSet
module VertxSql
  #  Represents the results of a SQL query.
  #  <p>
  #  It contains a list for the column names of the results, and a list of <code>JsonArray</code> - one for each row of the
  #  results.
  class ResultSet
    # @private
    # @param j_del [::VertxSql::ResultSet] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxSql::ResultSet] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Array<String>] columnNames 
    # @param [Array<Array<String,Object>>] results 
    # @return [::VertxSql::ResultSet]
    def self.create(columnNames=nil,results=nil)
      if columnNames.class == Array && results.class == Array && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::IoVertxExtSql::ResultSet.java_method(:create, [Java::JavaUtil::List.java_class,Java::JavaUtil::List.java_class]).call(columnNames.map { |element| element },results.map { |element| ::Vertx::Util::Utils.to_json_array(element) }),::VertxSql::ResultSet)
      end
      raise ArgumentError, "Invalid arguments when calling create(columnNames,results)"
    end
    # @return [Array<Array<String,Object>>]
    def get_results
      if !block_given?
        return @j_del.java_method(:getResults, []).call().to_a.map { |elt| elt != nil ? JSON.parse(elt.encode) : nil }
      end
      raise ArgumentError, "Invalid arguments when calling get_results()"
    end
    #  Get the results
    # @return [Array<Array<String,Object>>] the results
    def results
      if !block_given?
        return @j_del.java_method(:results, []).call().to_a.map { |elt| elt != nil ? JSON.parse(elt.encode) : nil }
      end
      raise ArgumentError, "Invalid arguments when calling results()"
    end
    # @return [Array<String>]
    def get_column_names
      if !block_given?
        return @j_del.java_method(:getColumnNames, []).call().to_a.map { |elt| elt }
      end
      raise ArgumentError, "Invalid arguments when calling get_column_names()"
    end
    #  Get the column names
    # @return [Array<String>] the column names
    def column_names
      if !block_given?
        return @j_del.java_method(:columnNames, []).call().to_a.map { |elt| elt }
      end
      raise ArgumentError, "Invalid arguments when calling column_names()"
    end
    #  Get the rows - each row represented as a JsonObject where the keys are the column names and the values are
    #  the column values.
    #  <p>
    #  Beware that it's legal for a query result in SQL to contain duplicate column names, in which case one will
    #  overwrite the other if using this method. If that's the case use {::VertxSql::ResultSet#get_results} instead.
    # @return [Array<Hash{String => Object}>] the rows represented as JSON object instances
    def get_rows
      if !block_given?
        return @j_del.java_method(:getRows, []).call().to_a.map { |elt| elt != nil ? JSON.parse(elt.encode) : nil }
      end
      raise ArgumentError, "Invalid arguments when calling get_rows()"
    end
    #  Return the number of rows in the result set
    # @return [Fixnum] the number of rows
    def get_num_rows
      if !block_given?
        return @j_del.java_method(:getNumRows, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_num_rows()"
    end
    #  Return the number of columns in the result set
    # @return [Fixnum] the number of columns
    def get_num_columns
      if !block_given?
        return @j_del.java_method(:getNumColumns, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_num_columns()"
    end
  end
end
