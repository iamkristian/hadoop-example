package com.iamkristian.mapreduce.entities;

import org.junit.Test;

import static junit.framework.Assert.*;

/**
 * ...
 *
 * @author iamkristian
 */
public class OnDemandLogFileStatementTest {

    final String statement = "130.225.103.21 2010-08-19 23:59:58 - /storage/Auto/ODPNyheder/deadline/deadline170020100819.wmv 12 2 1 200 {3300AD50-2C39-46c0-AE0A-628614FFC158} 11.0.5721.5275 en-US Mozilla/4.0_(compatible;_MSIE_7.0;_Windows_NT_5.1;_.NET_CLR_1.1.4322;_.NET_CLR_2.0.50727;_.NET_CLR_3.0.04506.30;_InfoPath.1;_.NET_CLR_3.0.04506.648)_(WMFSDK/11.0.5721.5275)_WMPlayer/11.0.5721.5268 http://www.dr.dk/DR2/Deadline17/Deadline17.htm iexplore.exe 7.0.6000.17080 Windows_XP 5.1.0.2600 Pentium 2114 429483770 2060257 rtsp TCP - - - 591975 591975 284 284 0 0 0 0 0 0 1 2 100 172.18.203.20 ODFILE02.dr.dk 190 3 - 701260 file://E:\\wmdata\\Auto/ODPNyheder/deadline/deadline170020100819.wmv mms://WMSC.dr.dk/storage/Auto/ODPNyheder/deadline/deadline170020100819.wmv?WMContentBitrate=1024000 deadline170020100819.wmv 2560542 - 0"; 
    @Test
    public void testCreateStatement() {
        OnDemandLogStatement stmt = new OnDemandLogStatement(statement);
        assertEquals("130.225.103.21", stmt.c_ip);
        assertEquals("-", stmt.c_dns);
        assertEquals("2010-08-19", stmt.date);
        assertEquals("/storage/Auto/ODPNyheder/deadline/deadline170020100819.wmv", stmt.cs_uri_stem);
        assertEquals("/storage/Auto/ODPNyheder/deadline/deadline170020100819.wmv", stmt.cs_uri_stem);

    }
}
