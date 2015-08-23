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

package com.refreshsf.contrib.client.api;

import com.refreshsf.contrib.client.Result;
import com.refreshsf.contrib.client.opts.HtmlOptions;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * API interface for '/html/'
 *
 * @link http://refresh-sf.com/#htmlminifier
 * @link https://github.com/kangax/html-minifier
 */
public interface Html {

    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/html/")
    @FormUrlEncoded
    public Result minify(
            @Field("code") String code,
            @FieldMap HtmlOptions options
    );



    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/html/")
    @FormUrlEncoded
    public void minifyAsync(
            @Field("code") String code,
            @FieldMap HtmlOptions options,
            Callback<Result> callback
    );

}
