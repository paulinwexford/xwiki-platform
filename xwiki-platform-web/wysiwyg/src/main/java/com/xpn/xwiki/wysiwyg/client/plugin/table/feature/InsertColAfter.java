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
package com.xpn.xwiki.wysiwyg.client.plugin.table.feature;

import com.google.gwt.dom.client.TableCellElement;
import com.google.gwt.user.client.ui.PushButton;
import com.xpn.xwiki.wysiwyg.client.editor.Images;
import com.xpn.xwiki.wysiwyg.client.editor.Strings;
import com.xpn.xwiki.wysiwyg.client.plugin.table.TablePlugin;
import com.xpn.xwiki.wysiwyg.client.widget.rta.RichTextArea;
import com.xpn.xwiki.wysiwyg.client.widget.rta.cmd.Command;

/**
 * Feature allowing to insert a column at the right of an existing column. After the insertion the caret is positioned
 * in the cell at the right of the originally edited cell. It is disabled when the caret is positioned outside of a
 * column. A column is a set of cells aligned vertically in a table.
 * 
 * @version $Id$
 */
public class InsertColAfter extends AbstractTableFeature
{
    /**
     * Initialize the feature. Table features needs to be aware of the plug-in (here the ClickListener) since they hold
     * their own PushButton.
     * 
     * @param plugin table plug-in.
     */
    public InsertColAfter(TablePlugin plugin)
    {
        name = "insertcolafter";
        command = new Command(name);
        button = new PushButton(Images.INSTANCE.insertColAfter().createImage(), plugin);
        button.setTitle(Strings.INSTANCE.insertColAfter());
    }

    /**
     * {@inheritDoc}
     * 
     * @see Executable#execute(RichTextArea, String)
     */
    public boolean execute(RichTextArea rta, String parameter)
    {
        TableCellElement currentCell = utils.getCell(utils.getCaretNode(rta.getDocument()));
        utils.insertCol(rta.getDocument(), false);
        utils.putCaretInNode(rta, utils.getNextCellInRow(currentCell));
        return true;
    }

    /**
     * {@inheritDoc}
     * 
     * @see Executable#isEnabled(RichTextArea)
     */
    public boolean isEnabled(RichTextArea rta)
    {
        return utils.getCell(utils.getCaretNode(rta.getDocument())) != null;
    }
}
