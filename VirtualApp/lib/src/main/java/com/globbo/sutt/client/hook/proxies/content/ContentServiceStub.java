package com.globbo.sutt.client.hook.proxies.content;

import com.globbo.sutt.client.hook.base.BinderInvocationProxy;
import com.globbo.sutt.client.hook.base.Inject;

import mirror.android.content.IContentService;

/**
 * @author Lody
 * @see IContentService
 */
@Inject(MethodProxies.class)
public class ContentServiceStub extends BinderInvocationProxy {

    public ContentServiceStub() {
        super(IContentService.Stub.asInterface, "content");
    }
}
