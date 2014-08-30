/**
 * To generate the WeblogRecord.Java ensure that Thrift is installed. Copy the Thrift file
 * and run this thrift --gen java weblogrecord.thrift to create a Java class for WeblogRecord
 */
namespace java thriftserialization
struct WeblogRecord {
1: optional string cookie,
2: string page,
3: i64 timestamp,
4: string ip
}