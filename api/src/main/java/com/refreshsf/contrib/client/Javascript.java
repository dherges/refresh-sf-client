/*
 * refresh-sf client
 *
 * Copyright 2015 dherges <david@spektrakel.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.refreshsf.contrib.client;

import retrofit.Callback;
import retrofit.http.*;

/**
 * API interface for '/javascript/'
 */
public interface Javascript {

    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/javascript/")
    @FormUrlEncoded
    public Result compress(
            @Field("code") String code,
            @Field("type") String type,
            @FieldMap JavascriptOptions options
    );



    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/javascript/")
    @FormUrlEncoded
    public void compressAsync(
            @Field("code") String code,
            @Field("type") String type,
            @Field("options") JavascriptOptions options,
            Callback<Result> callback
    );


}
