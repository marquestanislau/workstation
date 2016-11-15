<div class="documentacaos index">
	<h2><?php echo __('Documentacaos'); ?></h2>
        <table class="table table-hover" cellpadding="0" cellspacing="0">
	<thead>
	<tr>
			<th><?php echo $this->Paginator->sort('id'); ?></th>
			<th><?php echo $this->Paginator->sort('nome'); ?></th>
			<th><?php echo $this->Paginator->sort('carreira_id'); ?></th>
			<th><?php echo $this->Paginator->sort('concurso_id'); ?></th>
			<th class="actions"><?php echo __('Actions'); ?></th>
	</tr>
	</thead>
	<tbody>
	<?php foreach ($documentacaos as $documentacao): ?>
	<tr>
		<td><?php echo h($documentacao['Documentacao']['id']); ?>&nbsp;</td>
		<td><?php echo h($documentacao['Documentacao']['nome']); ?>&nbsp;</td>
		<td>
			<?php echo $this->Html->link($documentacao['Carreira']['nome'], array('controller' => 'carreiras', 'action' => 'view', $documentacao['Carreira']['id'])); ?>
		</td>
		<td>
			<?php echo $this->Html->link($documentacao['Concurso']['data_aprovacao'], array('controller' => 'concursos', 'action' => 'view', $documentacao['Concurso']['id'])); ?>
		</td>
		<td class="actions">
			<?php echo $this->Html->link(__('View'), array('action' => 'view', $documentacao['Documentacao']['id']), array('class' => 'btn btn-default')); ?>
			<?php echo $this->Html->link(__('Edit'), array('action' => 'edit', $documentacao['Documentacao']['id']), array('class' => 'btn btn-default')); ?>
			<?php echo $this->Form->postLink(__('Delete'), array('action' => 'delete', $documentacao['Documentacao']['id']), 
                                array('class' => 'btn btn-default', 'confirm' => __('Are you sure you want to delete # %s?', $documentacao['Documentacao']['id']))); ?>
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
		<li><?php echo $this->Html->link(__('New Documentacao'), array('action' => 'add')); ?></li>
		<li><?php echo $this->Html->link(__('List Carreiras'), array('controller' => 'carreiras', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Carreira'), array('controller' => 'carreiras', 'action' => 'add')); ?> </li>
		<li><?php echo $this->Html->link(__('List Concursos'), array('controller' => 'concursos', 'action' => 'index')); ?> </li>
		<li><?php echo $this->Html->link(__('New Concurso'), array('controller' => 'concursos', 'action' => 'add')); ?> </li>
	</ul>
</div>
