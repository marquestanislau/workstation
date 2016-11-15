<div class="col-md-8">
    <h5><?php echo __('Lista de docentes da universidade pedagogica'); ?></h5>

     <div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-warning" type="button">Procurar!</button>
      </span>
    </div>
    <div></div>
    <table class="table table-striped" cellpadding="0" cellspacing="0">
        <thead>
            <tr>
                <th><?php echo $this->Paginator->sort('#'); ?></th>
                <th><?php echo $this->Paginator->sort('cadeira'); ?></th>
                <th><?php echo $this->Paginator->sort('funcionario_id'); ?></th>
                <th class="actions"><?php echo __('Actions'); ?></th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($cds as $cd): ?>
                <tr>
                    <td><?php echo h($cd['Cd']['id']); ?>&nbsp;</td>
                    <td><?php echo h($cd['Cd']['cadeira']); ?>&nbsp;</td>
                    <td>
                        <?php echo $this->Html->link($cd['Funcionario']['nome'], array('controller' => 'funcionarios', 'action' => 'view', $cd['Funcionario']['id'])); ?>
                    </td>
                    <td class="actions">
                        <?php echo $this->Html->link("<span class='glyphicon glyphicon-eye-open'></span> Detalhes", array('action' => 'view', $cd['Cd']['id']), array('escape' => false)); ?>
                        <?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span> Editar", array('action' => 'edit', $cd['Cd']['id']), array('escape' => false)); ?>
                        <?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $cd['Cd']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $cd['Cd']['id']), 'escape' => false)); ?>
                    </td>
                </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
    <p>
        <?php
        echo $this->Paginator->counter(array(
            'format' => __('Page {:page} of {:pages}, showing {:current} records out of {:count} total, starting on record {:start}, ending on {:end}')
        ));
        ?>	</p>
    <div class="paging">
        <?php
        echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled'));
        echo $this->Paginator->numbers(array('separator' => ''));
        echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled'));
        ?>
    </div>
</div>
<div class="col-md-4">
    <div class="list-group">
        <a href="#" class="list-group-item active">
            <h4><span class="glyphicon glyphicon-menu-hamburger"></span> <?php echo __('Menu'); ?></h4>
        </a>
        <?php 
            echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Adicionar novo docente", array('action' => 'add'), array('class' => 'list-group-item', 'escape' => false));
            echo $this->Html->link("<span class='glyphicon glyphicon-user'></span> Lista de funcionarios", array('controller' => 'funcionarios', 'action' => 'index'), array('class' => 'list-group-item', 'escape' => false));
            echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de tecnicos", array('controller' => 'ctas', 'action' => 'index'), array('class' => 'list-group-item', 'escape' => false));
        ?>
    </div>
</div>

