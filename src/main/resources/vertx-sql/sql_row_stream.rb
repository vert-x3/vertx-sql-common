require 'vertx/read_stream'
require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.sql.SQLRowStream
module VertxSql
  #  A ReadStream of Rows from the underlying RDBMS. This class follows the ReadStream semantics and will automatically
  #  close the underlying resources if all returned rows are returned. For cases where the results are ignored before the
  #  full processing of the returned rows is complete the close method **MUST** be called in order to release underlying
  #  resources.
  # 
  #  The interface is minimal in order to support all SQL clients not just JDBC.
  class SQLRowStream
    include ::Vertx::ReadStream
    # @private
    # @param j_del [::VertxSql::SQLRowStream] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxSql::SQLRowStream] the underlying java delegate
    def j_del
      @j_del
    end
    @@j_api_type = Object.new
    def @@j_api_type.accept?(obj)
      obj.class == SQLRowStream
    end
    def @@j_api_type.wrap(obj)
      SQLRowStream.new(obj)
    end
    def @@j_api_type.unwrap(obj)
      obj.j_del
    end
    def self.j_api_type
      @@j_api_type
    end
    def self.j_class
      Java::IoVertxExtSql::SQLRowStream.java_class
    end
    # @yield 
    # @return [self]
    def exception_handler
      if block_given?
        @j_del.java_method(:exceptionHandler, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |event| yield(::Vertx::Util::Utils.from_throwable(event)) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling exception_handler()"
    end
    # @yield 
    # @return [self]
    def handler
      if block_given?
        @j_del.java_method(:handler, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |event| yield(event != nil ? JSON.parse(event.encode) : nil) }))
        return self
      end
      raise ArgumentError, "Invalid arguments when calling handler()"
    end
    # @return [self]
    def pause
      if !block_given?
        @j_del.java_method(:pause, []).call()
        return self
      end
      raise ArgumentError, "Invalid arguments when calling pause()"
    end
    # @return [self]
    def resume
      if !block_given?
        @j_del.java_method(:resume, []).call()
        return self
      end
      raise ArgumentError, "Invalid arguments when calling resume()"
    end
    # @yield 
    # @return [self]
    def end_handler
      if block_given?
        @j_del.java_method(:endHandler, [Java::IoVertxCore::Handler.java_class]).call(Proc.new { yield })
        return self
      end
      raise ArgumentError, "Invalid arguments when calling end_handler()"
    end
    #  Will convert the column name to the json array index.
    # @param [String] name the column name
    # @return [Fixnum] the json array index
    def column(name=nil)
      if name.class == String && !block_given?
        return @j_del.java_method(:column, [Java::java.lang.String.java_class]).call(name)
      end
      raise ArgumentError, "Invalid arguments when calling column(#{name})"
    end
    #  Event handler when a resultset is closed. This is useful to request for more results.
    # @yield 
    # @return [::VertxSql::SQLRowStream]
    def result_set_closed_handler
      if block_given?
        return ::Vertx::Util::Utils.safe_create(@j_del.java_method(:resultSetClosedHandler, [Java::IoVertxCore::Handler.java_class]).call(Proc.new { yield }),::VertxSql::SQLRowStream)
      end
      raise ArgumentError, "Invalid arguments when calling result_set_closed_handler()"
    end
    #  Request for more results if available
    # @return [void]
    def more_results
      if !block_given?
        return @j_del.java_method(:moreResults, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling more_results()"
    end
    #  Closes the stream/underlying cursor(s). The actual close happens asynchronously.
    # @yield called when the stream/underlying cursor(s) is(are) closed
    # @return [void]
    def close
      if !block_given?
        return @j_del.java_method(:close, []).call()
      elsif block_given?
        return @j_del.java_method(:close, [Java::IoVertxCore::Handler.java_class]).call((Proc.new { |ar| yield(ar.failed ? ar.cause : nil) }))
      end
      raise ArgumentError, "Invalid arguments when calling close()"
    end
  end
end
