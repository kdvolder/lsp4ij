/*******************************************************************************
 * Copyright (c) 2023 Red Hat Inc. and others.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0, or the Apache License, Version 2.0
 * which is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0
 *
 * Contributors:
 *     Red Hat Inc. - initial API and implementation
 *******************************************************************************/
package com.redhat.devtools.lsp4ij.operations.completion.snippet;

import com.redhat.devtools.lsp4ij.operations.completion.snippet.handler.LspSnippetNode;
import org.junit.Test;

import static com.redhat.devtools.lsp4ij.operations.completion.snippet.LspSnippetAssert.*;

public class AdvancedTest {

    @Test
    public void textAndlaceholdersAndTabStop() {
        LspSnippetNode[] actual = LspSnippetAssert.parse("{#for ${1:item} in ${2:items}}\n\t{${1:item}.${3:name}}$0\n{/for}");
        assertEquals(actual, LspSnippetAssert.text("{#for "), //
                LspSnippetAssert.placeholder(1, "item", 1), // ${1:item}
                LspSnippetAssert.text(" in "), //
                LspSnippetAssert.placeholder(2, "items", 1), // ${2:items}
                LspSnippetAssert.text("}\n\t{"), //
                LspSnippetAssert.placeholder(1, "item", 1), // ${1:item}
                LspSnippetAssert.text("."), //
                LspSnippetAssert.placeholder(3, "name", 1), // ${3:name}
                LspSnippetAssert.text("}"), //
                LspSnippetAssert.tabstop(0), //
                LspSnippetAssert.text("\n{/for}"));
    }

}
