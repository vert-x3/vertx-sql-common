require 'vertx/util/utils.rb'
# Generated from io.vertx.ext.sql.UpdateResult
module VertxSql
  #  Represents the result of an update/insert/delete operation on the database.
  #  <p>
  #  The number of rows updated is available with {::VertxSql::UpdateResult#get_updated} and any generated
  #  keys are available with {::VertxSql::UpdateResult#get_keys}.
  class UpdateResult
    # @private
    # @param j_del [::VertxSql::UpdateResult] the java delegate
    def initialize(j_del)
      @j_del = j_del
    end
    # @private
    # @return [::VertxSql::UpdateResult] the underlying java delegate
    def j_del
      @j_del
    end
    # @param [Fixnum] updated 
    # @param [Array<String,Object>] keys 
    # @return [::VertxSql::UpdateResult]
    def self.create(updated=nil,keys=nil)
      if updated.class == Fixnum && keys.class == Array && !block_given?
        return ::Vertx::Util::Utils.safe_create(Java::IoVertxExtSql::UpdateResult.java_method(:create, [Java::int.java_class,Java::IoVertxCoreJson::JsonArray.java_class]).call(updated,::Vertx::Util::Utils.to_json_array(keys)),::VertxSql::UpdateResult)
      end
      raise ArgumentError, "Invalid arguments when calling create(updated,keys)"
    end
    # @return [Fixnum]
    def get_updated
      if !block_given?
        return @j_del.java_method(:getUpdated, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling get_updated()"
    end
    #  Get the number of rows updated
    # @return [Fixnum] number of rows updated
    def updated
      if !block_given?
        return @j_del.java_method(:updated, []).call()
      end
      raise ArgumentError, "Invalid arguments when calling updated()"
    end
    # @return [Array<String,Object>]
    def get_keys
      if !block_given?
        return @j_del.java_method(:getKeys, []).call() != nil ? JSON.parse(@j_del.java_method(:getKeys, []).call().encode) : nil
      end
      raise ArgumentError, "Invalid arguments when calling get_keys()"
    end
    #  Get any generated keys
    # @return [Array<String,Object>] generated keys
    def keys
      if !block_given?
        return @j_del.java_method(:keys, []).call() != nil ? JSON.parse(@j_del.java_method(:keys, []).call().encode) : nil
      end
      raise ArgumentError, "Invalid arguments when calling keys()"
    end
  end
end
