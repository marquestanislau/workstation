<div class="col-md-8">
<div class="input-group">
      <input type="text" class="form-control" placeholder="Search for...">
      <span class="input-group-btn">
        <button class="btn btn-success" type="button">Procurar!</button>
      </span>
    </div>
    <h2><?php echo __('Ctas'); ?></h2>
    <table class="table table-hover" cellpadding="0" cellspacing="0">
        <thead>
            <tr>
                <th><?php echo $this->Paginator->sort('#'); ?></th>
                <th><?php echo $this->Paginator->sort('nome'); ?></th>
                <th><?php echo $this->Paginator->sort('apelido'); ?></th>
                <th><?php echo $this->Paginator->sort('sexo'); ?></th>
                <th class="actions"><?php echo __('Actions'); ?></th>
            </tr>
        </thead>
        <tbody>
	<?php foreach ($ctas as $cta): ?>
            <tr>
                <td><?php echo h($cta['Cta']['id']); ?>&nbsp;</td>
                <td>
			<?php echo $this->Html->link($cta['Funcionario']['nome'], array('controller' => 'funcionarios', 'action' => 'view', $cta['Funcionario']['id'])); ?>
                </td>
                <td><?php echo $cta['Funcionario']['apelido'] ?></td>
                <td><?php echo $cta['Funcionario']['sexo'] ?></td>
                <td class="actions">
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-eye-open'></span> Visualizar", array('action' => 'view', $cta['Cta']['id']), array('escape' => false)); ?>
			<?php echo $this->Html->link("<span class='glyphicon glyphicon-edit'></span> Editar", array('action' => 'edit', $cta['Cta']['id']), array('escape' => false)); ?>
			<?php echo $this->Form->postLink("<span class='glyphicon glyphicon-trash'></span> Remover", array('action' => 'delete', $cta['Cta']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $cta['Cta']['id']), 'escape' => false)); ?>
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
    <ul class="pager">
        <li><a href=""><?php echo $this->Paginator->prev('< ' . __('previous'), array(), null, array('class' => 'prev disabled')); ?></a></li>
        <li><a href=""><?php echo $this->Paginator->numbers(array('separator' => ''));
        echo $this->Paginator->next(__('next') . ' >', array(), null, array('class' => 'next disabled')); ?></a></li>
        <li></li>
    </ul>
    </div>
</div>
<div class="col-md-4">
    <div class="list-group">
      <a href="#" class="list-group-item active">
        <h4><span class="glyphicon glyphicon-menu-hamburger"></span> <?php echo __('Menu'); ?></h4>
      </a>
      <?php 
        echo $this->Html->link("<span class='glyphicon glyphicon-plus'></span> Adicionar tecnico", array('action' => 'add'), array('class' => 'list-group-item', 'escape' => false));
        echo $this->Html->link("<span class='glyphicon glyphicon-list'></span> Lista de tecnicos", array('controller' => 'funcionarios', 'action' => 'index'), array('class' => 'list-group-item', 'escape' => false));
        echo $this->Html->link("<span class='glyphicon glyphicon-user'></span> Lista de todos funcionarios", array('controller' => 'funcionarios', 'action' => 'add'), array('class' => 'list-group-item', 'escape' => false));
      ?>
    </div>
</div>
