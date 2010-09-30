/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.listener;

/**
 * Represents a link reference to an <a href="http://en.wikipedia.org/wiki/InterWiki">Inter Wiki</a> link. An InterWiki
 * link is a shorthand notation to link to a set of external URL, all having a common prefix (eg
 * http://server/some/common/prefix/a1, http://server/some/common/prefix/a2). An InterWiki link is made of an InterWiki
 * Alias which is a name corresponding to the common URL and an InterWiki Path which is the suffix to append to the
 * common URL part to make the full URL.
 *
 * @version $Id$
 * @since 2.5M2
 */
public class InterWikiLink extends Link
{
    /**
     * The name of the parameter representing the InterWiki Alias.
     */
    public static final String INTERWIKI_ALIAS = "interWikiAlias";

    /**
     * Sets the link type automatically.
     */
    public InterWikiLink()
    {
        setType(LinkType.INTERWIKI);
        setTyped(true);
    }

    /**
     * @param interWikiAlias see {@link #getInterWikiAlias()}
     */
    public void setInterWikiAlias(String interWikiAlias)
    {
        setParameter(INTERWIKI_ALIAS, interWikiAlias);
    }

    /**
     * @return the <a href="http://en.wikipedia.org/wiki/InterWiki">Inter Wiki</a> alias to which the link is pointing
     *         to or null if not defined. Mappings between Inter Wiki aliases and actual locations are defined in the
     *         Inter Wiki Map. Example: "wikipedia"
     */
    public String getInterWikiAlias()
    {
        return (String) getParameter(INTERWIKI_ALIAS);
    }
}
