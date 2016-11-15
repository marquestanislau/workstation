<div class="col-md-8">     <h4 class="settings-font-color"><span style="font-size: 24px;" class="glyphicon glyphicon-map-marker"></span><?php
                                                                 echo
                                                                 __('Listas das Delega&ccedil;&otilde;es');
                                                                 ?></h4>     <table class="table
                     table-hover" cellpadding="0" cellspacing="0">     <thead>     <tr>
                <th><?php echo $this->Paginator->sort('id'); ?></th>             <th><?php echo $this->Paginator->sort('nome'); ?></th>             <th
                    class="actions"><?php echo __('Actions'); ?></th>     </tr>     </thead>
        <tbody>     <?php foreach ($delegacaos as $delegacao): ?>     <tr>
                    <td><?php echo h($delegacao['Delegacao']['id']); ?>&nbsp;</td>
                    <td><?php echo h($delegacao['Delegacao']['nome']); ?>&nbsp;</td>         <td
                        class="actions">             <?php
                            echo $this->Html->link("<span
class='glyphicon glyphicon-eye-open'></span> Ver", array('action' => 'view',
                                $delegacao['Delegacao']['id']), array('escape' => false));
                            ?>
                            <?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span>
Editar", array('action' => 'edit', $delegacao['Delegacao']['id']), array('escape' => false));
                            ?>             <?php
                            echo
                            $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span>
Remover", array('action' => 'delete', $delegacao['Delegacao']['id']), array('escape' => false, 'confirm' => __('Are you sure you want to delete #
%s?', $delegacao['Delegacao']['id'])));
                            ?>         </td>     </tr> <?php endforeach; ?>     </tbody>     </table>     <p>     <?php
        echo
        $this->Paginator->counter(array('format' => __('Page {:page} of
{:pages}, showing {:current} records out of {:count} total, starting on record
{:start}, ending on {:end}')));
        ?>  </p>     <div class="paging">
                        <?php
                        echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
                        echo
                        $this->Paginator->numbers(array('separator' => ''));
                        echo
                        $this->Paginator->next(__('next') . ' >', array(), null, array('class' =>
                            'next disabled'));
                        ?>     </div> </div> <div class="col-md-4">     <div
        class="list-group">         <a href="" class="list-group-item active">
            <h3><?php echo __('Menu'); ?></h3>         </a>         <?php
            echo
            $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Adicionar
delega&ccedil;&atilde;o", array('action' => 'add'), array('class' => 'list-group-item', 'escape' => false));
                        ?>     </div>

    <ul>
        <li></li>
    </ul>
</div>
