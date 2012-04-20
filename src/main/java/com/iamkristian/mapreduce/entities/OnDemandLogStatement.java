package com.iamkristian.mapreduce.entities;

import java.lang.reflect.Field;

/**
 * ...
 *
 * @author iamkristian
 */
public class OnDemandLogStatement {

    /***
         Do NOT rearrange the order in which these fields are defined, it represents the order in which they are defined in the logfile
     ***/
    public String c_ip;
    public String date;
    public String time;
    public String c_dns;
    public String cs_uri_stem;
    public String c_starttime;
    public String x_duration;
    public String c_rate;
    public String c_status;
    public String c_playerid;
    public String c_playerversion;
    public String c_playerlanguage;
    public String csUser_Agent;
    public String csReferer;
    public String c_hostexe;
    public String c_hostexever;
    public String c_os;
    public String c_osversion;
    public String c_cpu;
    public String filelength;
    public String filesize;
    public String avgbandwidth;
    public String protocol;
    public String transport;
    public String audiocodec;
    public String videocodec;
    public String channelURL;
    public String sc_bytes;
    public String c_bytes;
    public String s_pkts_sent;
    public String c_pkts_received;
    public String c_pkts_lost_client;
    public String c_pkts_lost_net;
    public String c_pkts_lost_cont_net;
    public String c_resendreqs;
    public String c_pkts_recovered_ECC;
    public String c_pkts_recovered_resent;
    public String c_buffercount;
    public String c_totalbuffertime;
    public String c_quality;
    public String s_ip;
    public String s_dns;
    public String s_totalclients;
    public String s_cpu_util;
    public String cs_user_name;
    public String s_session_id;
    public String s_content_path;
    public String cs_url;
    public String cs_media_name;
    public String c_max_bandwidth;
    public String cs_media_role;
    public String s_proxied;
    public OnDemandLogStatement(String stmt) {
        String[] entries = stmt.split(" ");
        Field[] fields = OnDemandLogStatement.class.getDeclaredFields();
        int n = 0;
        for (String entry : entries) {
            try {
                fields[n++].set(this, entry);
            } catch (IllegalAccessException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }



}
