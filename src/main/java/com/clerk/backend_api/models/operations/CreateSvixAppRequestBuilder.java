/* 
 * Code generated by Speakeasy (https://speakeasy.com). DO NOT EDIT.
 */

package com.clerk.backend_api.models.operations;


public class CreateSvixAppRequestBuilder {

    private final SDKMethodInterfaces.MethodCallCreateSvixApp sdk;

    public CreateSvixAppRequestBuilder(SDKMethodInterfaces.MethodCallCreateSvixApp sdk) {
        this.sdk = sdk;
    }

    public CreateSvixAppResponse call() throws Exception {

        return sdk.createSvixAppDirect();
    }
}
