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

import com.refreshsf.contrib.client.types.opts.JavascriptOptions;
import com.refreshsf.contrib.client.types.Result;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FieldMap;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;

/**
 * API interface for '/javascript/'
 *
 * @link http://refresh-sf.com/#uglify
 * @link https://github.com/mishoo/UglifyJS2
 */
public interface Javascript {

    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/javascript/")
    @FormUrlEncoded
    public Result uglify(
            @Field("code") String code,
            @FieldMap JavascriptOptions options
    );



    @Headers({
            "Accept: application/json, text/javascript, */*; q=0.01",
            "User-Agent: Refresh-SF-Java-Client"
    })
    @POST("/javascript/")
    @FormUrlEncoded
    public void uglifyAsync(
            @Field("code") String code,
            @FieldMap JavascriptOptions options,
            Callback<Result> callback
    );


}
