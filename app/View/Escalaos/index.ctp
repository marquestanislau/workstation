<div class="escalaos index">
	<h2><?php echo __('Escalaos'); ?></h2>
        <table class="table table-hover" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('nome'); ?></th>
			<th><?php echo $this->Paginator->sort('categoria_id'); ?></th>
			<th><?php echo $this->Paginator->sort('clazze_id'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($escalaos as $escalao): ?>
	<tr>
		<td><?php echo h($escalao['Escalao']['id']); ?>&nbsp;</td>
		<td><?php echo h($escalao['Escalao']['nome']); ?>&nbsp;</td>
		<td>
			<?php echo $this->Html->link($escalao['Categoria']['nome'], array('controller' => 'categorias', 'action' => 'view', $escalao['Categoria']['id'])); ?>
		</td>
		<td>
			<?php echo $this->Html->link($escalao['Clazze']['nome'], array('controller' => 'clazzes', 'action' => 'view', $escalao['Clazze']['id'])); ?>
		</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $escalao['Escalao']['id'])); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $escalao['Escalao']['id'])); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $escalao['Escalao']['id']), array('confirm' => __('Are you sure you want to delete # %s?', $escalao['Escalao']['id']))); ?>
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
<div class="actions">
	<h3><?php echo __('Actions'); ?></h3>
	<ul>
		<li><?php echo $this->Html->link(__('New Escalao'), array('action' => 'add')); ?></li>
		<li><?php echo $this->Html->link(__('List Categorias'), array('controller' => 'categorias', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Categoria'), array('controller' => 'categorias', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Classes'), array('controller' => 'clazzes', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Classes'), array('controller' => 'clazzes', 'action' => 'add')); ?> </li>
	</ul>
</div>
