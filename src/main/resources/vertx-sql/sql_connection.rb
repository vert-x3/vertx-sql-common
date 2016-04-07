require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.sql.SQLConnection
module VertxSql
  #  Represents a connection to a SQL database
  class SQLConnection
    # @private
    # @param j_del [::VertxSql::SQLConnection] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxSql::SQLConnection] the underlying java delegate
    def j_del
      @j_del
    end
    #  Sets the auto commit flag for this connection. True by default.
    # @param [true,false] autoCommit the autoCommit flag, true by default.
    # @yield the handler which is called once this operation completes.
    # @return [self]
    def set_auto_commit(autoCommit=nil)
      if (autoCommit.class == TrueClass || autoCommit.class == FalseClass) && block_given?
        @j_del.java_method(:setAutoCommit, [Java::boolean.java_class,Java::IoVertxCore::Handler.java_class]).call(autoCommit,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling set_auto_commit(autoCommit)"
    end
    #  Executes the given SQL statement
    # @param [String] sql the SQL to execute. For example <code>CREATE TABLE IF EXISTS table ...</code>
    # @yield the handler which is called once this operation completes.
    # @return [self]
    def execute(sql=nil)
      if sql.class == String && block_given?
        @j_del.java_method(:execute, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling execute(sql)"
    end
    #  Executes the given SQL <code>SELECT</code> statement which returns the results of the query.
    # @param [String] sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    # @yield the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
    # @return [self]
    def query(sql=nil)
      if sql.class == String && block_given?
        @j_del.java_method(:query, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling query(sql)"
    end
    #  Executes the given SQL <code>SELECT</code> prepared statement which returns the results of the query.
    # @param [String] sql the SQL to execute. For example <code>SELECT * FROM table ...</code>.
    # @param [Array<String,Object>] params these are the parameters to fill the statement.
    # @yield the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
    # @return [self]
    def query_with_params(sql=nil,params=nil)
      if sql.class == String && params.class == Array && block_given?
        @j_del.java_method(:queryWithParams, [Java::java.lang.String.java_class,Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,::Vertx::Util::Utils.to_json_array(params),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling query_with_params(sql,params)"
    end
    #  Executes the given SQL statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    #  statement.
    # @param [String] sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    # @yield the handler which is called once the operation completes.
    # @return [self]
    def update(sql=nil)
      if sql.class == String && block_given?
        @j_del.java_method(:update, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling update(sql)"
    end
    #  Executes the given prepared statement which may be an <code>INSERT</code>, <code>UPDATE</code>, or <code>DELETE</code>
    #  statement with the given parameters
    # @param [String] sql the SQL to execute. For example <code>INSERT INTO table ...</code>
    # @param [Array<String,Object>] params these are the parameters to fill the statement.
    # @yield the handler which is called once the operation completes.
    # @return [self]
    def update_with_params(sql=nil,params=nil)
      if sql.class == String && params.class == Array && block_given?
        @j_del.java_method(:updateWithParams, [Java::java.lang.String.java_class,Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,::Vertx::Util::Utils.to_json_array(params),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling update_with_params(sql,params)"
    end
    #  Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    # @param [String] sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
    # @yield the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
    # @return [self]
    def call(sql=nil)
      if sql.class == String && block_given?
        @j_del.java_method(:call, [Java::java.lang.String.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling call(sql)"
    end
    #  Calls the given SQL <code>PROCEDURE</code> which returns the result from the procedure.
    # @param [String] sql the SQL to execute. For example <code>{call getEmpName (?, ?)}</code>.
    # @param [Array<String,Object>] params these are the parameters to fill the statement.
    # @param [Array<String,Object>] outputs these are the outputs to fill the statement.
    # @yield the handler which is called once the operation completes. It will return a <code>ResultSet</code>.
    # @return [self]
    def call_with_params(sql=nil,params=nil,outputs=nil)
      if sql.class == String && params.class == Array && outputs.class == Array && block_given?
        @j_del.java_method(:callWithParams, [Java::java.lang.String.java_class,Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCoreJson::JsonArray.java_class,Java::IoVertxCore::Handler.java_class]).call(sql,::Vertx::Util::Utils.to_json_array(params),::Vertx::Util::Utils.to_json_array(outputs),(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result != nil ? JSON.parse(ar.result.toJson.encode) : nil : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling call_with_params(sql,params,outputs)"
    end
    #  Closes the connection. Important to always close the connection when you are done so it's returned to the pool.
    # @yield the handler called when this operation completes.
    # @return [void]
    def close
      if !block_given?
        return @j_del.java_method(:close, []).call()
      elsif block_given?
        return @j_del.java_method(:close, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling close()"
    end
    #  Commits all changes made since the previous commit/rollback.
    # @yield the handler called when this operation completes.
    # @return [self]
    def commit
      if block_given?
        @j_del.java_method(:commit, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling commit()"
    end
    #  Rolls back all changes made since the previous commit/rollback.
    # @yield the handler called when this operation completes.
    # @return [self]
    def rollback
      if block_given?
        @j_del.java_method(:rollback, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling rollback()"
    end
    #  Batch simple SQL strings and execute the batch where the async result contains a array of Integers.
    # @param [Array<String>] sqlStatements sql statement
    # @yield the result handler
    # @return [self]
    def batch(sqlStatements=nil)
      if sqlStatements.class == Array && block_given?
        @j_del.java_method(:batch, [Java::JavaUtil::List.java_class,Java::IoVertxCore::Handler.java_class]).call(sqlStatements.map { |element| element },(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result.to_a.map { |elt| elt } : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling batch(sqlStatements)"
    end
    #  Batch a prepared statement with all entries from the args list. Each entry is a batch.
    #  The operation completes with the execution of the batch where the async result contains a array of Integers.
    # @param [String] sqlStatement sql statement
    # @param [Array<Array<String,Object>>] args the prepared statement arguments
    # @yield the result handler
    # @return [self]
    def batch_with_params(sqlStatement=nil,args=nil)
      if sqlStatement.class == String && args.class == Array && block_given?
        @j_del.java_method(:batchWithParams, [Java::java.lang.String.java_class,Java::JavaUtil::List.java_class,Java::IoVertxCore::Handler.java_class]).call(sqlStatement,args.map { |element| ::Vertx::Util::Utils.to_json_array(element) },(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result.to_a.map { |elt| elt } : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling batch_with_params(sqlStatement,args)"
    end
    #  Batch a callable statement with all entries from the args list. Each entry is a batch.
    #  The size of the lists inArgs and outArgs MUST be the equal.
    #  The operation completes with the execution of the batch where the async result contains a array of Integers.
    # @param [String] sqlStatement sql statement
    # @param [Array<Array<String,Object>>] inArgs the callable statement input arguments
    # @param [Array<Array<String,Object>>] outArgs the callable statement output arguments
    # @yield the result handler
    # @return [self]
    def batch_callable_with_params(sqlStatement=nil,inArgs=nil,outArgs=nil)
      if sqlStatement.class == String && inArgs.class == Array && outArgs.class == Array && block_given?
        @j_del.java_method(:batchCallableWithParams, [Java::java.lang.String.java_class,Java::JavaUtil::List.java_class,Java::JavaUtil::List.java_class,Java::IoVertxCore::Handler.java_class]).call(sqlStatement,inArgs.map { |element| ::Vertx::Util::Utils.to_json_array(element) },outArgs.map { |element| ::Vertx::Util::Utils.to_json_array(element) },(Proc.new { |ar| yield(ar.failed ? ar.cause : nil, ar.succeeded ? ar.result.to_a.map { |elt| elt } : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling batch_callable_with_params(sqlStatement,inArgs,outArgs)"
    end
  end
end
